package com.learning.niit_project.controllers;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.ws.FaultAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.learning.niit_project.models.FacultyModel;
import com.learning.niit_project.models.QR_Details;
import com.learning.niit_project.services.IFacultyDAO;
import com.learning.niit_project.services.I_QRdao;

@Controller
public class FacultyController  {

	@Autowired
	IFacultyDAO iFacultyDAO;
	I_QRdao iQRdao;

//	@RequestMapping("/RegisterFaculty")
//	public String regFac()
//	{
//		FacultyModel model=new FacultyModel(101, "Kedar Devrukhkar", "Pass@1232", "FSSE", "TDD", "niit.kedar@gmail.com", 8828097172L);
//		iFacultyDAO.save(model);
//		return "faculty-reg";
//		
//	}
	
	@RequestMapping("/")
	public String index() {	 
		return "index";
	}

	@RequestMapping("/login")
	public String index(@RequestParam("facultyId") int facultyId, @RequestParam("pwd") String facultyPass,
			HttpServletRequest request) {
		Optional<FacultyModel> model = iFacultyDAO.findById(facultyId);
		if (model.isPresent()) {

			FacultyModel faculty = model.get();
			int id = faculty.getFacultyId();
			String password = faculty.getFacultyPwd();

			System.out.println(facultyId + " " + facultyPass);
			if (facultyId == id && facultyPass.equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute("facultyName", faculty.getFacultyName());
				return "qr-details";
			}

		}

		return "index";
	}

	@RequestMapping(path = "/generate_qr")
	public String generateQR(QR_Details qr_Details,HttpServletRequest request) {
			 TimerTask task = new TimerTask() {
			      @Override
			      public void run() {
			    	  qr_Details.setCurrentDateTime(new java.util.Date());
			    	 // System.out.println(qr_Details);
			    	  try {
						createQR(qr_Details);
					} catch (WriterException e) {
						// TODO Auto-generated catch block
						System.out.println("WriterException "+e);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("IOException "+e);
					}
			      }
			    };
			    Timer timer = new Timer();
			    long delay = 0;
			    long intevalPeriod = 5 * 1000; 
			    // schedules the task to be run in an interval 
			    timer.scheduleAtFixedRate(task, delay,
			                                intevalPeriod);
			 //iQRdao.save(qr_Details);
			    return "generate-qr";
	}


	
	private void createQR(QR_Details qr_Details) throws WriterException, IOException {

		String fileType = "jpg";
		String filePath = "src/main/webapp/faculty/QR-images/AttendanceQR.jpg";
		File qrFile = new File(filePath);
		Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		int size = 125;
		BitMatrix byteMatrix = qrCodeWriter.encode(qr_Details.toString(), BarcodeFormat.QR_CODE, size, size, hintMap);
		// Make the BufferedImage that are to hold the QRCode
		int matrixWidth = byteMatrix.getWidth();
		BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
		image.createGraphics();

		Graphics2D graphics = (Graphics2D) image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, matrixWidth, matrixWidth);
		// Paint and save the image using the ByteMatrix
		graphics.setColor(Color.BLACK);

		for (int i = 0; i < matrixWidth; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				if (byteMatrix.get(i, j)) {
					graphics.fillRect(i, j, 1, 1);
				}
			}
		}
		ImageIO.write(image, fileType, qrFile);
	}
//
//	@RequestMapping(path = "/error")
//	public String showErrPage()
//	{
//		return "errorpage";
//	}

}

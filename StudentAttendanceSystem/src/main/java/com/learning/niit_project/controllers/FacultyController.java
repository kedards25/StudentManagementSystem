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
	public String generateQR(QR_Details qr_Details) {
		try {
			
			final ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
	        ses.scheduleAtFixedRate(new Runnable() {
	            @Override
	            public void run() {
	                try {
	                	qr_Details.setCurrentDateTime(new java.util.Date());
	                	
	                	String nm=qr_Details.getFacultyName();
	                	String crse=qr_Details.getCourseName();
	                	String bat=qr_Details.getBatchCode();
	                	Date currDt=qr_Details.getCurrentDateTime();
	                	
	                	System.out.println(nm);
	                	System.out.println(crse);
	                	System.out.println(bat);
	                	System.out.println(currDt);
						createQR(qr_Details);
						
					} catch (WriterException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        }, 0, 1 , TimeUnit.SECONDS);
			
			 //iQRdao.save(qr_Details);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: " + e);
		}
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


}

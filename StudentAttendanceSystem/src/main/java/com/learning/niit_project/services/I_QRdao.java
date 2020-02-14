package com.learning.niit_project.services;

import org.springframework.data.repository.CrudRepository;

import com.learning.niit_project.models.QR_Details;

public interface I_QRdao extends CrudRepository<QR_Details,	Integer> {

}

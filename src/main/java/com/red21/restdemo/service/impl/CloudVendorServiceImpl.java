package com.red21.restdemo.service.impl;

import com.red21.restdemo.exception.CloudVendorNotFoundException;
import com.red21.restdemo.model.CloudVendor;
import com.red21.restdemo.repository.CloudVendorRepository;
import com.red21.restdemo.service.CloudVendorService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

  CloudVendorRepository cloudVendorRepository;

  public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
    this.cloudVendorRepository = cloudVendorRepository;
  }

  @Override
  public String createCloudVendor(CloudVendor cloudVendor) {
    // More Business Logic
    cloudVendorRepository.save(cloudVendor);
    return "Success";
  }

  @Override
  public String updateCloudVendor(CloudVendor cloudVendor) {
    // More Business Logic
    cloudVendorRepository.save(cloudVendor);
    return "Success";
  }

  @Override
  public String deleteCloudVendor(String cloudVendorId) {
    // More Business Logic
    cloudVendorRepository.deleteById(cloudVendorId);
    return "Success";
  }

  @Override
  public CloudVendor getCloudVendor(String cloudVendorId) {
    // More Business Logic
    if (cloudVendorRepository.findById(cloudVendorId).isEmpty())
      throw new CloudVendorNotFoundException(
          "Requested Cloud Vendor does not exist");
    return cloudVendorRepository.findById(cloudVendorId).get();
  }

  @Override
  public List<CloudVendor> getAllCloudVendors() {
    // More Business Logic
    return cloudVendorRepository.findAll();
  }

  @Override
  public List<CloudVendor> getByVendorName(String vendorName) {
    return cloudVendorRepository.findByVendorName(vendorName);
  }
}

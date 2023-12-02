package com.red21.restdemo.repository;

import com.red21.restdemo.model.CloudVendor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudVendorRepository
    extends JpaRepository<CloudVendor, String> {
  List<CloudVendor> findByVendorName(String vendorName);
}

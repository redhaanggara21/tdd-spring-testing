package com.red21.restdemo.repository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.red21.restdemo.model.CloudVendor;
import com.red21.restdemo.repository.CloudVendorRepository;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CloudVendorRepositoryTest {

  //  given - when - then

  @Autowired private CloudVendorRepository cloudVendorRepository;
  CloudVendor cloudVendor;

  @BeforeEach
  void setUp() {
    cloudVendor = new CloudVendor("1", "Amazon", "USA", "xxxxx");
    cloudVendorRepository.save(cloudVendor);
  }

  @AfterEach
  void tearDown() {
    cloudVendor = null;
    cloudVendorRepository.deleteAll();
  }

  // Test case SUCCESS

  @Test
  void testFindByVendorName_Found() {
    List<CloudVendor> cloudVendorList =
        cloudVendorRepository.findByVendorName("Amazon");
    assertThat(cloudVendorList.get(0).getVendorId())
        .isEqualTo(cloudVendor.getVendorId());
    assertThat(cloudVendorList.get(0).getVendorAddress())
        .isEqualTo(cloudVendor.getVendorAddress());
  }

  // Test case FAILURE
  @Test
  void testFindByVendorName_NotFound() {
    List<CloudVendor> cloudVendorList =
        cloudVendorRepository.findByVendorName("GCP");
    assertThat(cloudVendorList.isEmpty()).isTrue();
  }
}

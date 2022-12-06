package com.fups.testcase.repository;

import com.fups.testcase.entity.menu.Campaigns;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignsRepository extends JpaRepository<Campaigns, Long> {
}

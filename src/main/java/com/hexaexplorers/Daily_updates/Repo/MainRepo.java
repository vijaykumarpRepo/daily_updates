package com.hexaexplorers.Daily_updates.Repo;

import com.hexaexplorers.Daily_updates.Entity.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainRepo extends JpaRepository<Info,Long> {
}

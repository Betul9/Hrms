package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.GradSchool;

public interface GradSchoolDao extends JpaRepository<GradSchool, Integer>{

}

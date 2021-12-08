/**
 * @author Jacob Krebs
 * CIS175 - Fall 2021
 * Dec 7, 2021
 */
package dmacc.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import dmacc.beans.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Long> {

	/**
	 * @param id
	 * @return
	 */
	List<Employee> findById(long id);

}

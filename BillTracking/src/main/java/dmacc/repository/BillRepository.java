/**
 * @author Bryner Gibson - bpgibson1
 * CIS175 - Fall 2021
 * Nov 16, 2021
 */
package dmacc.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

	/**
	 * @param id
	 * @return
	 */
	List<Bill> findByEmpId(long id);

}

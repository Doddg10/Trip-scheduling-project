package trip_scheduling.project.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import trip_scheduling.project.entities.Admin;
import org.springframework.stereotype.Service;



import trip_scheduling.project.repositories.AdminRepository;

@Service
public class AdminService {

	private final AdminRepository adminR;
	private String email;
	private String password;


	@Autowired
	public AdminService(AdminRepository adminR) {
		this.adminR = adminR;
	}

	public void addAdmin(Admin ad) {
		java.util.Optional<Admin> adminOptional = adminR.findAdminByEmail(ad.getEmail());

		if (adminOptional.isPresent()) {
			throw new IllegalStateException("Email taken");

		}


		adminR.save(ad);

	}


	

	public ResponseEntity<Admin> adminSignInCheck(Admin ad) {


				flag = true;

			}

		}

		if (flag == true)
			//return "login successfull.";
			return ResponseEntity.ok(ad);
		else
			return (ResponseEntity<Admin>) ResponseEntity.internalServerError();

	}



}


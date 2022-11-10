package trip_scheduling.project.services;


import org.springframework.beans.factory.annotation.Autowired;
import trip_scheduling.project.entities.Admin;
import org.springframework.stereotype.Service;



import trip_scheduling.project.repositories.AdminRepository;

@Service
public class AdminService {

	private final AdminRepository adminR;

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

	public String adminSignInCheck(Admin ad) {
		boolean flag = false;
		for (int i = 0; i < adminR.findAll().size(); i++) {
			if (adminR.findAll().get(i).getEmail().equals(ad.getEmail())
					&& adminR.findAll().get(i).getPassword().equals(ad.getPassword())) {


				flag = true;

			}

		}

		if (flag == true)
			return "login successfull.";
		else
			return "login failed";

	}


}


package trip_scheduling.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import trip_scheduling.project.entities.Admin;
import org.springframework.stereotype.Service;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
import trip_scheduling.project.repositories.AdminRepository;

@Service
public class AdminService {
	private final AdminRepository adminRepository;
	private String email;
	private String password;

	@Autowired
	public AdminService(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}

	public void addNewAdmin(Admin admin) {
		java.util.Optional<Admin> adminOptional = adminRepository.findAdminByEmail(admin.getEmail());
		if (adminOptional.isPresent()) {
			throw new IllegalStateException("Email taken");

		}

		adminRepository.save(admin);

	}

	public String SignInAdmin(Admin admin) {
		boolean flag = false;
		for (int i = 0; i < adminRepository.findAll().size(); i++) {
			if (adminRepository.findAll().get(i).getEmail().equals(admin.getEmail())
					&& adminRepository.findAll().get(i).getPassword().equals(admin.getPassword())) {

				flag = true;

			}

		}

		if (flag == true)
			return "login successfull.";
		else
			return "login failed";

	}

}

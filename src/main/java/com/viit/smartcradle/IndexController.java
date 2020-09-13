package com.viit.smartcradle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.viit.smartcradle.dao.ProfileDataDao;
import com.viit.smartcradle.dao.SensorDataDao;
import com.viit.smartcradle.entity.PostResponseBody;
import com.viit.smartcradle.entity.Profile;
import com.viit.smartcradle.entity.SensorData;

@Controller
@SpringBootApplication
public class IndexController {
	@Autowired
	SensorDataDao sensorDataDao;
	@Autowired
	ProfileDataDao profileDataDao;


	@RequestMapping("/edit-profile")
	public ModelAndView getSettings() {
		ModelAndView mvProfileData = new ModelAndView("edit-profile");// Shows edit-profile.jsp file
		Profile d = profileDataDao.get();
		mvProfileData.addObject("profileData", d);
		return mvProfileData;
	}

	@RequestMapping("/")
	public ModelAndView getIndex() {
		ModelAndView indexFileObject = new ModelAndView("index");// Shows index.jsp file
		Profile p = profileDataDao.get();
		indexFileObject.addObject("profileData", p);
		try {
			SensorData d = sensorDataDao.get();
			indexFileObject.addObject("sensorData", d);
		} catch (Exception e) {
			SensorData d = new SensorData();
			indexFileObject.addObject("sensorData", d);
			e.printStackTrace();

		}
		return indexFileObject;
	}

	@RequestMapping(value = "/api/feed", method = RequestMethod.GET)
	public ResponseEntity<SensorData> getLatest() {
		try {
			SensorData latest = sensorDataDao.get();
			return new ResponseEntity<SensorData>(latest, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<SensorData>(new SensorData(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/api/feed", method = RequestMethod.POST)
	public @ResponseBody PostResponseBody addData(@RequestBody SensorData data) {
		return sensorDataDao.addNew(data);
	}

	@PostMapping("/edit-profile") // it only support port method
	public String saveProfile(@RequestParam("mobNo") String mobNo, @RequestParam("babyName") String babyName,
			ModelMap modelMap) {

		Profile newProfile = new Profile(mobNo, babyName);
		profileDataDao.setProfile(newProfile);
		modelMap.put("profileData", newProfile);
		return "edit-profile"; // welcome is view name. It will call welcome.jsp
	}

	@RequestMapping(value = "/api/profile", method = RequestMethod.GET)
	public ResponseEntity<Profile> get() {
		Profile profile = profileDataDao.get();
		return new ResponseEntity<Profile>(profile, HttpStatus.OK);
	}

	public static void main(String[] args) {
		SpringApplication.run(IndexController.class, args);
	}
}

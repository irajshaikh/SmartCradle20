package com.viit.smartcradle.dao;

import org.springframework.stereotype.Repository;

import com.viit.smartcradle.entity.Profile;

@Repository
public class ProfileDataDao {

	private Profile currProfile = new Profile("9421716050", "Boo");

	public Profile get() {
		return currProfile;
	}

	public void setProfile(Profile profile) {
		this.currProfile = profile;
		System.out.println("Profile set successfully");

	}

}

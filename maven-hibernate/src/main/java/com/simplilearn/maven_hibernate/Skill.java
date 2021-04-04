package com.simplilearn.maven_hibernate;

import javax.persistence.Embeddable;

@Embeddable
public class Skill {

		private String skillName;
		private String skillRating;
		public Skill() {
			
		}
		
		
		public Skill(String skillName, String skillRating) {
			super();
			this.skillName = skillName;
			this.skillRating = skillRating;
		}
		public String getSkillName() {
			return skillName;
		}
		public void setSkillName(String skillName) {
			this.skillName = skillName;
		}
		public String getSkillRating() {
			return skillRating;
		}
		public void setSkillRating(String skillRating) {
			this.skillRating = skillRating;
		}
		
}

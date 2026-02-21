package com.bim.in.pojo;

public class PermRolePojo {

		private int roleNumber;
		
		private String permRole;

		public int getRoleNumber() {
			return roleNumber;
		}

		public void setRoleNumber(int roleNumber) {
			this.roleNumber = roleNumber;
		}

		public String getPermRole() {
			return permRole;
		}

		public void setPermRole(String permRole) {
			this.permRole = permRole;
		}

		public PermRolePojo(int roleNumber, String permRole) {
			super();
			this.roleNumber = roleNumber;
			this.permRole = permRole;
		}

		public PermRolePojo() {
			super();
			// TODO Auto-generated constructor stub
		}

		

}

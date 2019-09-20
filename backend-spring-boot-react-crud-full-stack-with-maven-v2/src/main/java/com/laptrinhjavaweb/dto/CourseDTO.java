package com.laptrinhjavaweb.dto;


//Từ khóa super trong java là một biến tham chiếu được sử dụng để tham chiếu trực 
//tiếp đến đối tượng của lớp cha gần nhất.

//trong trường hợp này CourseDTO đang kế thừa từ class cha là class.
//class có các phương thức sau :equals,finalize,getClass,hashCode,toString

//Từ khóa final được dùng để tạo hằng số, có nghĩa là nó được gán một lần duy nhất.

public class CourseDTO extends AbstractDTO<CourseDTO>{

	private String username;	
	private String description;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CourseDTO() {

	}
	
	public CourseDTO(Long id,String username,String description) {		
		super();	
		this.username = username;
		this.description = description;				
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((this.getId() == null) ? 0 : this.getId().hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseDTO other = (CourseDTO) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (this.getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!this.getId().equals(other.getId()))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
}

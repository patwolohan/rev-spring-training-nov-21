package ie.rc.userdao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AnnotatedUser {
	
	private int id;
	private String name;
	private String email;
	private boolean active;

	public static void main(String[] args) {
		
		AnnotatedUser u = new AnnotatedUser(1, "Aidan", "aidan@gmail.com", true);
		
		System.out.println(u);
		
		System.out.println(u.getName());
		
		u.setName("Changed");
		
		System.out.println(u);
		
	}
}

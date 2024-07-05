package eTender.example.eTender.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int categoryId; 		
	private String category;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<CreateTender> getCreatetender() {
		return createtender;
	}

	public void setCreatetender(List<CreateTender> createtender) {
		this.createtender = createtender;
	}

	@OneToMany(mappedBy="category")
	@JsonIgnore
	private List<CreateTender>createtender;
}

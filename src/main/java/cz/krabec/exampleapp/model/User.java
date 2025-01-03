package cz.krabec.exampleapp.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;


/**
 * Details of a user
 */
@ApiModel(description = "Details of a user")
@Validated


public class User   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("password")
  private String password = null;

  public User id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Unique ID of the user
   * @return id
  **/
  @ApiModelProperty(example = "1", value = "Unique ID of the user")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public User name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Unique username for the user
   * @return name
  **/
  @ApiModelProperty(example = "johndoe", required = true, value = "Unique username for the user")
  @NotNull

@Size(min=3,max=50)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public User password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Password for the user
   * @return password
  **/
  @ApiModelProperty(example = "P@ssw0rd", required = true, value = "Password for the user")
  @NotNull

@Size(min=8) 
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.id, user.id) &&
        Objects.equals(this.name, user.name) &&
        Objects.equals(this.password, user.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


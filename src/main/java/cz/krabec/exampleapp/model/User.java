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
  @NotNull
  @JsonProperty("id")
  private Integer id = null;


  @JsonProperty("name")
  @Size( max = 30)
  private String name = null;

  @NotNull
  @Size(min = 4, max = 30)
  @JsonProperty("username")
    private String username = null;

  @NotNull
  @Size(max = 30)
  @JsonProperty("password")
  private String password = null;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}


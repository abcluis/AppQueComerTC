package com.itchihuahuaii.quecomer.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IngredientRecipe {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("ingredient_id")
@Expose
private Integer ingredientId;
@SerializedName("recipe_id")
@Expose
private Integer recipeId;
@SerializedName("quantity_ingredient")
@Expose
private Integer quantityIngredient;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public Integer getIngredientId() {
return ingredientId;
}

public void setIngredientId(Integer ingredientId) {
this.ingredientId = ingredientId;
}

public Integer getRecipeId() {
return recipeId;
}

public void setRecipeId(Integer recipeId) {
this.recipeId = recipeId;
}

public Integer getQuantityIngredient() {
return quantityIngredient;
}

public void setQuantityIngredient(Integer quantityIngredient) {
this.quantityIngredient = quantityIngredient;
}

}
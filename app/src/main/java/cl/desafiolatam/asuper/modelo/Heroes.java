package cl.desafiolatam.asuper.modelo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Heroes{

	@SerializedName("Heroes")
	private List<HeroesItem> heroes;

	public void setHeroes(List<HeroesItem> heroes){
		this.heroes = heroes;
	}

	public List<HeroesItem> getHeroes(){
		return heroes;
	}

	@Override
 	public String toString(){
		return 
			"Heroes{" + 
			"heroes = '" + heroes + '\'' + 
			"}";
		}
}
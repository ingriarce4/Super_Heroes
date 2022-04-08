package cl.desafiolatam.asuper.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import cl.desafiolatam.asuper.cliente.ClienteRetrofit;
import cl.desafiolatam.asuper.modelo.Heroes;
import cl.desafiolatam.asuper.modelo.HeroesItem;
import cl.desafiolatam.asuper.servicio.HeroeServicio;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeroeViewModel extends ViewModel {

    private HeroeServicio servicio = ClienteRetrofit.getInstance();
    private MutableLiveData<List<HeroesItem>> listHeroe = new MutableLiveData<>();
    private MutableLiveData<HeroesItem> miHeroe = new MutableLiveData<>();

   //llamar Api
    public void llamarApi(){
        servicio.getHeores().enqueue(new Callback<List<HeroesItem>>() {
            @Override
            public void onResponse(Call<List<HeroesItem>> call, Response<List<HeroesItem>> response) {
                //llamadas en otro hilo
                listHeroe.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<HeroesItem>> call, Throwable t) {
                //para saber si tengo un error
                Log.i("API ", t.getMessage());
                call.cancel();
            }
        });
    }

    public void obtenerHeroe (HeroesItem heroesItem){
        miHeroe.setValue(heroesItem);
    }

    public MutableLiveData<List<HeroesItem>> getListHeroe() {
        return listHeroe;
    }
    public MutableLiveData<HeroesItem> getDetalle(){
        return miHeroe;
    }
}

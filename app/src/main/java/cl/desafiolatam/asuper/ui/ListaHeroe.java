package cl.desafiolatam.asuper.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.desafiolatam.asuper.R;
import cl.desafiolatam.asuper.adapter.HeroeAdapter;
import cl.desafiolatam.asuper.databinding.FragmentListaHeroeBinding;
import cl.desafiolatam.asuper.modelo.HeroesItem;
import cl.desafiolatam.asuper.viewmodel.HeroeViewModel;


public class ListaHeroe extends Fragment {

    private FragmentListaHeroeBinding binding;
    private HeroeViewModel viewModel;
    private HeroeAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentListaHeroeBinding.inflate(inflater, container, false);
        // Activity toma el instanciamos un viewmodel
        viewModel = new ViewModelProvider(getActivity()).get(HeroeViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        //instanciamos adapter
        adapter = new HeroeAdapter();
        GridLayoutManager manager = new GridLayoutManager(getContext(), 1);
        binding.heroes.setAdapter(adapter);
        binding.heroes.setLayoutManager(manager);

        adapter.setListener(new HeroeAdapter.MiOnClickListener() {
            @Override
            public void onClickListener(HeroesItem heroesItem) {
                viewModel.obtenerHeroe(heroesItem);
                Navigation.findNavController(getView()).navigate(R.id.action_listaHeroe_to_detalleHeroe);
            }
        });

        viewModel.getListHeroe().observe(getViewLifecycleOwner(), heroe ->{
          //  Log.i("API", heroe.toString());
            //cuando se observe los superheores
            adapter.setLista(heroe);
        });
        //super.onViewCreated(view, savedIstanceState);
    }
}
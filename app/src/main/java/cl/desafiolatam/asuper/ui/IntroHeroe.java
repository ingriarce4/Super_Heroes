package cl.desafiolatam.asuper.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.desafiolatam.asuper.R;
import cl.desafiolatam.asuper.databinding.FragmentIntroHeroeBinding;
import cl.desafiolatam.asuper.viewmodel.HeroeViewModel;


public class IntroHeroe extends Fragment {

    private FragmentIntroHeroeBinding binding;
    private HeroeViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentIntroHeroeBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(getActivity()).get(HeroeViewModel.class);

        // Inflate the layout for this fragment

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.button.setOnClickListener(v -> {
            Navigation.findNavController(getView()).navigate(R.id.action_introHeroe_to_listaHeroe);
        });
    }
}
package cl.desafiolatam.asuper.viewmodel;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.google.common.truth.Truth;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import cl.desafiolatam.asuper.modelo.Heroes;
import cl.desafiolatam.asuper.modelo.HeroesItem;

//importamos Mockito
@RunWith(MockitoJUnitRunner.class)
public class HeroeViewModelTest {

    //prueba al ViewModel cuando llamo al api

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private Observer<List<HeroesItem>> listObserver;

    @Mock
    private Observer<HeroesItem> heroesObserver;

    private HeroeViewModel viewModel;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        //creo una instancia
        viewModel = new HeroeViewModel();
        viewModel.getListHeroe().observeForever(listObserver);
        viewModel.getDetalle().observeForever(heroesObserver);

    }
    @Test
    public void llamarApiTest() throws InterruptedException {

        viewModel.llamarApi();
        Thread.sleep(3000);
        List<HeroesItem> lista = viewModel.getListHeroe().getValue();
        verify(listObserver).onChanged(viewModel.getListHeroe().getValue());

    }

//    @Test
//    public void test_llamar_api()
//    {
//        viewModel.llamarApi();
//        Thread.sleep(3000);
//        List<HeroesItem> lista = viewModel.getListHeroe().getValue();
//        Heroes h = lista.g
//
//      //  Truth.assertThat(m).isNotNull();
//
//
//    }
}
package net.kodar.university.service.service;


import net.kodar.university.business.processor.discipline.DisciplineProcessorGenericImpl;
import net.kodar.university.data.entities.Discipline;
import net.kodar.university.presentation.depricated.parameter.DisciplineParam;
import net.kodar.university.presentation.depricated.result.DisciplineResult;

import net.kodar.university.presentation.service.discipline.DisciplineService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class DisciplineServiceTests{

    @MockBean
    private DisciplineProcessorGenericImpl disciplineProcessor;

    @Autowired
    private DisciplineService disciplineService;

    @Captor
    ArgumentCaptor<DisciplineParam> disciplineCaptor;

    private static final Integer VALID_ID = 1;

    private static final Integer INVALID_ID = -1;

    private static Discipline VALID_DISCIPLINE;

    private static DisciplineResult VALID_DISCIPLINE_RESULT;

    private static DisciplineParam VALID_DISCIPLINE_PARAM;

    @Before
    public void setUp() throws Exception {
        VALID_DISCIPLINE = new Discipline();
        VALID_DISCIPLINE.setName("Test");
        VALID_DISCIPLINE.setId(VALID_ID);

        VALID_DISCIPLINE_RESULT = new DisciplineResult("Test");
        VALID_DISCIPLINE_RESULT.setId(VALID_ID);

        VALID_DISCIPLINE_PARAM = new DisciplineParam("Test");
        VALID_DISCIPLINE_PARAM.setId(VALID_ID);
    }

    @Test
    public void get_givenDiscipline_returnsTheCorrectDiscipline(){
        when(disciplineProcessor.get(VALID_ID)).thenReturn(VALID_DISCIPLINE_RESULT);

        DisciplineResult disciplineResult = disciplineService.get(VALID_ID);

        assertEquals(disciplineResult.getName(), VALID_DISCIPLINE.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void get_givenInvalidId_ShouldThrowException() {
        when(disciplineProcessor.get(INVALID_ID)).thenThrow(new IllegalArgumentException());
        disciplineService.get(INVALID_ID);
    }

    @Test
    public void getAll_givenTwoDisciplines_shouldReturnTwoDisciplines() {
        List<DisciplineResult> disciplineList =  Arrays.asList(VALID_DISCIPLINE_RESULT, VALID_DISCIPLINE_RESULT);

        when(disciplineProcessor.getAll()).thenReturn(disciplineList);

        assertEquals(disciplineService.getAll().size(), 2);
    }

    @Test
    public void delete_tryToDeleteADiscipline_shouldThrowException() {
        when(disciplineProcessor.get(VALID_ID)).thenReturn(VALID_DISCIPLINE_RESULT);

        disciplineService.delete(VALID_ID);
        verify(disciplineProcessor, times(1)).delete(VALID_ID);
    }

    @Test(expected = Exception.class)
    public void update_givenWrongId_ShouldThrowException() throws Exception {
        doThrow(new Exception()).when(disciplineProcessor).update(VALID_DISCIPLINE_PARAM);

        disciplineService.update(INVALID_ID, VALID_DISCIPLINE_PARAM);
    }

    @Test
    public void update_givenDisciplineToUpdate_ShouldUseTheDisciplineRepositorySave() throws Exception {

        doNothing().when(disciplineProcessor).update(VALID_DISCIPLINE_PARAM);

        disciplineService.update(VALID_ID, VALID_DISCIPLINE_PARAM);

        verify(disciplineProcessor, times(1)).update(disciplineCaptor.capture());
    }

    @Test(expected = Exception.class)
    public void save_givenDisciplineToSave_ShouldUseTheDisciplineRepositorySave() throws Exception {

        doNothing().when(disciplineProcessor).save(VALID_DISCIPLINE_PARAM);

        disciplineService.save(VALID_DISCIPLINE_PARAM);

        verify(disciplineProcessor, times(1)).save(disciplineCaptor.capture());
    }


}

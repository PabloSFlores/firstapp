package mx.edu.utez.firstapp.services.person;

import mx.edu.utez.firstapp.models.person.Person;
import mx.edu.utez.firstapp.models.person.PersonRepository;
import mx.edu.utez.firstapp.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonService {
    @Autowired
    private PersonRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Person>> getAll(){
        return new CustomResponse<>(
                this.repository.findAll(),
                false,
            200,
            "Ok"
        );
    }

    public CustomResponse<Person> savePerson(Person person){
        return new CustomResponse<>(
                this.repository.save(person),
                false,
                200,
                "Ok"
        );
    }
    public CustomResponse<String> deletePerson(Long id){
        this.repository.deleteById(id);
        return new CustomResponse<>(
                "Eliminado",
                false,
                200,
                "Ok"
        );
    }
}
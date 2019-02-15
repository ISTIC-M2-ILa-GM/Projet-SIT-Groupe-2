package fr.univ_rennes1.istic.sit.groupe2.dronemissionplanner.network;

import fr.univ_rennes1.istic.sit.groupe2.dronemissionplanner.models.Person;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SpringApiInterface {
    @GET("people/{id}")
    Call<Person> getOneCharacter(@Path("id") int id);
}

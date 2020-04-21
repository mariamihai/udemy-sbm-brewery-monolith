package guru.springframework.brewery.monolith.bootstrap;

import guru.springframework.brewery.monolith.domain.Brewery;
import guru.springframework.brewery.monolith.repositories.BreweryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BreweryLoader implements CommandLineRunner {

    private final BreweryRepository breweryRepository;

    @Override
    public void run(String... args) {
        loadBreweryDate();
    }

    private void loadBreweryDate() {
        if(breweryRepository.count() == 0) {
            breweryRepository.save(Brewery
                    .builder()
                    .breweryName("Dummy Brewery 1")
                    .build());
            breweryRepository.save(Brewery
                    .builder()
                    .breweryName("Dummy Brewery 2")
                    .build());
        }
    }
}

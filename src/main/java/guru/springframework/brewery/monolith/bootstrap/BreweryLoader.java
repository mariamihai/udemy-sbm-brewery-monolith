package guru.springframework.brewery.monolith.bootstrap;

import guru.springframework.brewery.monolith.domain.Beer;
import guru.springframework.brewery.monolith.domain.Brewery;
import guru.springframework.brewery.monolith.repositories.BeerRepository;
import guru.springframework.brewery.monolith.repositories.BreweryRepository;
import guru.springframework.brewery.monolith.web.model.BeerStyleEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class BreweryLoader implements CommandLineRunner {

    private final BreweryRepository breweryRepository;
    private final BeerRepository beerRepository;


    private static final String BEER_1_UPC = "1234567890";
    private static final String BEER_2_UPC = "9087654321";
    private static final String BEER_3_UPC = "1122334455";

    @Override
    public void run(String... args) {
        loadBreweryDate();
    }

    private void loadBreweryDate() {
        if(breweryRepository.count() == 0) {
            saveBrewery("Dummy Brewery 1");
            saveBrewery("Dummy Brewery 2");

            saveBeer("Dummy Beer 1", BeerStyleEnum.ALE, BEER_1_UPC);
            saveBeer("Dummy Beer 2", BeerStyleEnum.PALE_ALE, BEER_2_UPC);
            saveBeer("Dummy Beer 3", BeerStyleEnum.PILSNER, BEER_3_UPC);
        }
    }

    private void saveBrewery(String breweryName) {
        Brewery savedBrewery = breweryRepository.save(Brewery.builder()
                .breweryName(breweryName)
                .build());

        log.info("Brewery '" + breweryName + "' was saved with id: " + savedBrewery.getId());
    }

    private void saveBeer(String beerName, BeerStyleEnum beerStyle, String upc) {
        Beer beer = Beer.builder()
                        .beerName(beerName)
                        .beerStyle(beerStyle)
                        .minOnHand(12)
                        .quantityToBrew(200)
                        .upc(upc)
                    .build();

        Beer savedBeer = beerRepository.save(beer);

        log.info("Beer '" + beerName + "' was saved with id: " + savedBeer.getId());
    }
}

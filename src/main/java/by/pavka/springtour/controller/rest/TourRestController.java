package by.pavka.springtour.controller.rest;

//@RestController
//@RequestMapping("api/tours")
public class TourRestController {
    //TODO fix LogAspect
//    @Autowired
//    TourDaoImpl dao;
//
//    @GetMapping("")
//    public ResponseEntity<List<Tour>> getTours() {
//        List<Tour> tours = dao.getAllTours();
//        return new ResponseEntity<>(tours, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Tour> getTour(@PathVariable int id) {
//        Tour tour = dao.getTourById(id);
//        if (tour == null) {
//            throw new NoSuchIDException("No such Tour ID exists");
//        }
//        return new ResponseEntity<>(tour, HttpStatus.OK);
//    }
//
//    @PutMapping("")
//    public ResponseEntity<Tour> updateTour(@RequestBody Tour tour) {
//        dao.updateTour(tour);
//        return new ResponseEntity<>(tour, HttpStatus.OK);
//    }
//
//    @PostMapping("")
//    public ResponseEntity<Tour> addTour(@RequestBody Tour tour) {
//        int key = dao.addTour(tour);
//        tour.setId(key);
//        return new ResponseEntity<>(tour, HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/{id}")
//    public HttpStatus deleteTour(@PathVariable int id) {
//        //TODO probably needs check for id out of range, like in UserController
//        dao.deleteTour(id);
//        return HttpStatus.NO_CONTENT;
//    }
}

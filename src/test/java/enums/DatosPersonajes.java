package enums;

public class DatosPersonajes {

    /**
     * Enum que contiene todos los datos de los personajes
     *
     * @author tinobboy
     * @version 0.1.0
     */
    public enum Personajes {
        Rick_Sanchez(1,"Rick Sanchez","Alive", "Human", "", "Male", "Earth (C-137)", "https://rickandmortyapi.com/api/location/1"),
        Morty_Smith(2,"Morty Smith","Alive", "Human", "", "Male", "unknown", ""),
        Summer_Smith(3,"Summer Smith","Alive", "Human", "", "Female", "Earth (Replacement Dimension)", "https://rickandmortyapi.com/api/location/20"),
        Beth_Smith(4,"Beth Smith","Alive", "Human", "", "Female", "Earth (Replacement Dimension)", "https://rickandmortyapi.com/api/location/20"),
        Jerry_Smith(5,"Jerry Smith","Alive", "Human", "", "Male", "Earth (Replacement Dimension)", "https://rickandmortyapi.com/api/location/20"),
        Bepisian(35,"Bepisian","Alive", "Alien", "Bepisian", "unknown", "Bepis 9", "https://rickandmortyapi.com/api/location/11"),
        Canklanker_Thom(62,"Canklanker Thom","Dead", "Alien", "Gromflomite", "Male", "Gromflom Prime", "https://rickandmortyapi.com/api/location/19");

        private int id;
        private String name;
        private String status;
        private String species;
        private String type;
        private String gender;
        private String origin_name;
        private String origin_url;

        Personajes(int id, String name, String status, String species, String type, String gender, String origin_name, String origin_url) {
            this.id = id;
            this.name = name;
            this.status = status;
            this.species = species;
            this.type = type;
            this.gender = gender;
            this.origin_name = origin_name;
            this.origin_url = origin_url;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSpecies() {
            return species;
        }

        public void setSpecies(String species) {
            this.species = species;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getOrigin_name() {
            return origin_name;
        }

        public void setOrigin_name(String origin_name) {
            this.origin_name = origin_name;
        }

        public String getOrigin_url() {
            return origin_url;
        }

        public void setOrigin_url(String origin_url) {
            this.origin_url = origin_url;
        }
    }
}

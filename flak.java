class Flak {
    private truckBedfunctionality state;
    
        public Flak() {
            state = new FullyOpenState(); // Starttillstånd
        }
    
        public void setState(truckBedfunctionality state) {
            this.state = state;
        }
    
        public void open() {
            state.fullyOpen(this);
        }
    
        public void close() {
            state.fullyClose(this);
        }

        public Boolean getState() {
            if (state instanceof FullyOpenState) {
                return false;
            } else {
                return true;
            } 
        }
}

class MyState {

   constructor() {
        this.my_score = 0;
        this.my_count = 0;
    }

    setScore(value) {
        this.my_score = value;
    }

    increment() {
        this.my_score = this.my_score +1;
    }

    zeroScore() {
        setScore(0);
   }

   getScore() {
        return this.my_score;
   }

} 

export default MyState;

/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    var num = init;
    const original = num;
    const increment = ()=>{
        num++;
        return num
    }
    const decrement = ()=>{
        num--;
        return num;
    }
    const reset = ()=>{
        num = original;
        return num
    }
    return {increment,decrement,reset}
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */
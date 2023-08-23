# Testing a JavaScript "Random Sampler"

![cover](https://cdn.hashnode.com/res/hashnode/image/upload/v1692734157035/7b75c2c4-e8f8-4d85-99ed-276caac7bca3.jpeg?w=1600&h=840&fit=crop&crop=entropy&auto=compress,format&format=webp)

I will wear my statistician hat as I scrutinize this JS one-liner:

```javascript
const getRandomItem =
    (items) => items[Math.floor(Math.random() * items.length)];
```

I saw it in a [video by James Q Quick](https://www.youtube.com/watch?v=cFqMk604en4), which was referencing [a freeCodeCamp article](https://www.freecodecamp.org/news/javascript-one-liners-to-use-in-every-project/). This is supposed to be a function that takes an array as input and returns a random element from that array. It triggered the statistician in me because we work a lot with randomness and uncertainty. We also do validate code like this before it's used in clinical studies. So, I'll give it some of the treatment I give to my R code.

## What to Validate

This is a very simple algorithm, so there is only one question that came to my mind:

> *Does every element in the input array have an equal probability of being sampled?*

The reason we should ask this question is that if the answer to that question is "no," then some elements have a higher chance of being sampled than others. In other words, the function would be somewhat biased and doesn't do what it's intended to do.

You might think that it's a bit overkill to do something like that. But I work in the pharmaceutical industry where code like this can - and will - affect how patients are exposed to the drugs under study or how their data are analyzed and interpreted. So, we care so much about code doing what it's supposed to do in a predictable and reproducible manner. Even in less critical scenarios, you'd want to avoid having some code mess up your business logic in any way, shape, or form.

On a related note, what I'm doing here is very similar to unit testing or, technically, it could be developed into a unit test with a couple of cases, but I'll settle for one example with some rough code. That should be enough to explain the idea. Also, I'm calling it "validation" because that's what we call it in my line of work (I'm wearing *that* hat after all).

## How to Validate

The main clue is in the question I put above: we need to validate the *probability* of sampling each element. But what is probability? In the statistical sense, it's the number of times a certain outcome has occurred out of the whole sample. If you flip a coin 10 times, your "expectation" is that 5 (50%) of them come up heads and the rest come up tails. That's exactly what we're doing, except that this works for an arbitrary number of outcomes, not just two (heads/tails).

We can apply this definition by simply executing the sampling process a large number of times and seeing how many times each element has been sampled, expecting them to be very close. Due to randomness, they will (almost) never be exactly equal. However, with larger samples, the numbers should come close to each other. That's what we call a *simulation* in statistics - we write code to produce the probabilities and see if our assumptions truly hold.

Let's make the idea more concrete with some rough code I wrote (**Warning**: watch out for the number of simulations - 99 million here - as they might take some time to complete).

```javascript
const testArray = ['a', 'b', 'c']
const counts = {a: 0, b: 0, c: 0}

let randomItem;
const simulations = 99_000_000

for (let i = 0; i < simulations; i++) {
    randomItem = getRandomItem(testArray)
    counts[randomItem]++
}

const proportions = {
    a: counts.a / simulations,
    b: counts.b / simulations,
    c: counts.c / simulations,
}

console.log(proportions)
```

With each iteration, the `for` loop gets a random item and increases the corresponding count inside the object `counts`. After it's done, we calculate the proportions which are our "simulated probabilities" (sorry, [my job forces me to sound sophisticated](https://codeforces.com/predownloaded/b7/8f/b78f0e086aa8c942869584bf6f71283d70e5ac51.png)). Since this is a 3-element array, we'd expect that each element would be sampled ~33% of the time.

## The Result

When I ran the code on Node.js, it printed out this:

```javascript
{
  a: 0.33326944444444445,
  b: 0.33337872727272727,
  c: 0.3333518282828283
}
```

We can see that the numbers are very close to each other, close enough for us to consider the function valid for its purpose. If you run the code, you will notice you won't get the same numbers - again because of randomness. They will always vary between runs, but should hopefully lead to the same conclusion every time (larger numbers of simulations will make you safer from anomalies).

Trying this with other examples should produce similar results: an array of 4 elements will yield numbers close to 0.25, and one of 10 elements will yield numbers close to 0.1... You get the idea. I'll leave that for you to try out.

## Final Notes

This was very simple in terms of JS complexity, but the underlying statistical concepts are quite nuanced. I find it quite interesting, and it gets even better when more variables enter the equation, but I don't want to go into that rabbit hole. Maybe later, though...

I hope you found that insightful or interesting.

* * *

Cover image source: [https://www.quantamagazine.org/how-randomness-can-make-math-easier-20190709/](https://www.quantamagazine.org/how-randomness-can-make-math-easier-20190709/)

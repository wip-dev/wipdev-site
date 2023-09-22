# Two Months of Clojure

![cover](https://i.imgur.com/YghZkHs.png)

At the time this article was published, two months had passed since I started learning Clojure. I read most of [Clojure for the Brave and True](https://www.braveclojure.com/clojure-for-the-brave-and-true/), solved a lot of problems on [Exercism](https://exercism.org/tracks/clojure) and [4clojure](http://4clojure.oxal.org/), and built a little SPA and a tiny web server from libraries. It has been a fun journey so far, and I'll recap some general thoughts about it here.

## Getting into Clojure from JavaScript

Since the programming language I've been using the most recently was JavaScript, I used it as the point of comparison to consider when analyzing the way Clojure works. I won't go into details here because I have a whole series of articles discussing these types of comparisons. At the time of writing this, I wrote:

* [Clojure as a Lisp](/posts/clojure-as-a-lisp.html)
    
* [Functional Programming](/posts/functional-programming.html)
    
* [Standard Library](/posts/standard-library.html)
    

These comparisons are still relatively shallow because there is a lot in Clojure to learn about. Nevertheless, Clojure gives a strong impression of being a more rich and advanced language than JavaScript. When I say this, I am referring to the base languages themselves and not the surrounding library ecosystem. Whether or not it's a valid comparison to make is up to you, but I'll especially recommend reading the Standard Library article for my detailed take on this topic.

Does this mean that development in Clojure is better than JS? Honestly, I don't know. I didn't interact with Clojure long enough to judge, but I will say that JS is hard to compete with in terms of 1) frameworks and 2) tooling. JS (TypeScript, too) remains, in my experience, the single best language in terms of tooling support.

## Challenges

Choosing Clojure as a functional language to learn turned out to be a real challenge. There are some concepts that I consider advanced. Macros, concurrency, atoms, refs, vars, and async are the ones that I have been introduced to so far. All these are new concepts that I have never encountered before unless async somehow matches the async JS, which it probably doesn't. There are even more concepts that I know nothing about. It's all Greek to me up to this point.

One thing I find intriguing in Clojure is that the predominant way of developing apps is to start from scratch and add libraries one by one as needed while using frameworks and boilerplate code is the standard in all other popular languages. It should be a great opportunity for me to learn more about the web itself and not some high-level abstraction of it. However, that will be another challenge on top of the language itself.

Finally, a lot of Clojure's strength lies in being hosted on the JVM (that's Java Virtual Machine) as it has some syntax for interoperability with Java classes, methods, etc. This is challenging because I knew nothing about Java, and up until now, I am not sure when or how people decide to use Java interop instead of Clojure itself.

## What's Next?

Not sure if this is Clojure or just the experience of starting a simple web server with routing, but I got intrigued enough to try backend development. Maybe my frustration with React pushed me in that direction as well. Who knows what goes in the human brain? As I continue my Clojure journey, I will try to learn more about the backend side of things.

To be transparent, I have to say that I am starting to have doubts about Clojure being *too* advanced for me. But still, I think I should give it more time to determine if it's just an initial bump or if things will become more treacherous. Only time will tell...
# 100 Days of Code: 1-10

![cover](https://cdn.hashnode.com/res/hashnode/image/upload/v1690831082825/c9d9a695-ef5f-4b8a-9f94-5f89f4e8443e.png?w=1600&h=840&fit=crop&crop=entropy&auto=compress,format&format=webp)

## Summary

In the first 10 days of my challenge, I got off to a good start with Clojure and ClojureScript and wrote 4 blog posts (other than this one). Not bad! There was also a failed attempt to start a ClojureScript frontend project. We'll see how it works out in the next 10 days.

Below are quick notes for what I did each day.

## Day 1 / 22 Jul

I started reading [Clojure for the Brave and True](https://www.braveclojure.com/clojure-for-the-brave-and-true/). I didn't do a lot of research on what to read: just picked up something and went right into it. The book is freely available online and seems to have lots of jokes, so that's enough for me.

So, I read the first introductory chapter and skipped the second one which was about Emacs (I'll stick to Neovim). Then, I read part of the third chapter which explains basic Clojure syntax and data structures. Been a while since I `(worked-with (all (those (parentheses))))`.

Blog-wise, I wrote a little in some drafts. Nothing complete.

## Day 2 / 23 Jul

In the blog, I started a new series called Overthinking Development where I, well... You get the idea. I published the first article in that series: [Pragmatism vs Idealism](https://wipdev.hashnode.dev/pragmatism-vs-idealism).

I also kept going with the Clojure book. It has some interesting data structures that I've yet to understand their practical value. However, one intriguing thing came up in the chapter:

> "It is better to have 100 functions operate on one data structure than 10 functions on 10 data structures." —Alan Perlis

It seems that the Clojure philosophy is to encourage the use of native data structures instead of making types or classes.

## Day 3 / 24 Jul

I got a quick look at ClojureScript, which is made for the web. The premise is that Clojure code compiles to Java code, and ClojureScript compiles to JavaScript. That means that Clojure draws its rules (in terms of types, equality rules, etc.) from Java, and ClojureScript from JS, and it means that the same expression might cause a different behavior in each language... Interesting.

I am starting to think I could try building a frontend with ClojureScript. That would be cool!

## Day 4 / 25 Jul

I took a little break from the written content and started watching a YouTube playlist named [Poetry of Programming](https://www.youtube.com/playlist?list=PLI-mrGTUXmHXeKhy6UGdDxIKwM8L4MTbq) (classy!). Sometimes, it's kinda hard to make big progress during the weekdays, but we still have 96 days so...

Also, I wrote a blog post: [**3 Challenges I Faced when Learning to Code**](https://wipdev.hashnode.dev/3-challenges-i-faced-when-learning-to-code)

## Day 5 / 26 Jul

Got back to the Clojure book. This day I practiced some iteration with recursion and `reduce`. Then, the chapter ended with a bunch of exercises.

The fun part is that I found out about shadow-cljs. I am still getting to know what it does and what it doesn't do, but all I care about for now is that the associated command-line utility, `create-cljs-project`, scaffolds a frontend project with React! This journey got cooler than I thought, faster than I thought!

## Day 6 / 27 Jul

I wrote a draft article. It's almost complete and should be published the next day.

## Day 7 / 28 Jul

Finished and published the article: [I Love/Hate JavaScript](https://wipdev.hashnode.dev/i-love-hate-javascript). Also, I played around with some Neovim plugins to enable Clojure interactive development. It took me so long to solve an issue that I had no idea where it came from. Almost called it a day without solving it, but I kept debugging until I did it.

## Day 8 / 29 Jul

I got the idea of starting another series about Clojure vs JavaScript in which I'll write down my observations as I learn Clojure(Script). Then, I acted and wrote the first article: [Clojure as a Lisp](https://wipdev.hashnode.dev/clojure-as-a-lisp).

That was the 4th article since the beginning of this challenge. That is probably enough for this 10-day span, but I will obviously start any drafts if an idea comes to mind.

I also watched a [really cool talk](https://www.youtube.com/watch?v=vK1DazRK_a0) that explained in newcomers's terms what functional programming looks like in a practical setting.

## Day 9 / 30 Jul

I kept going through the Poetry of Programming playlist. So far, its content is beginner-level, and it's an appreciated refresher, but I find interesting stuff here and there. Two cool things I discovered are short-circuiting in `and`/`or` functions and lazy sequences.

## Day 10 / 31 Jul

I tried to set up a frontend project using ClojureScript... and failed horribly! But it's okay. I did learn a couple of stuff related to configs, build tools, libraries, etc.

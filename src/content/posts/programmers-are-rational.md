# Programmers Are Rational — or Are They?

![cover](https://i.imgur.com/dcigENw.jpg)

Computers are mindless. We give them precise orders to follow using code. Our studying of programming is full of logic and possibly even math and science for some people. There are technical and business goals and constraints that inform our decision-making and problem-solving. So, all of this means that we as programmers are rational beings and capable of making the most calculated of decisions, right?

Wrong!

In this article, I will share my perspective on how objectivity forms only a small percentage of our work and also why people in our field might sometimes have this illusion of being objective.

## Programming as an Art and Science

The debates are there for not only languages and frameworks, but also paradigms, code style, tooling, and "best practices." We tend to get *opinionated* about our tools, and "opinionated" is a pretty accurate description, I believe. Modularity, readability, conciseness, and other words are thrown in the middle of these discussions, and they mean different things to different people. None of these things follow a standard that everyone should aspire to.

This is why I think that software is both *an art and a science*, and this is a great thing because it means it's a creative process. You get to form and develop your own thinking framework to understand any phenomenon and how things interact with each other. Then, you start expressing those ideas as code. There is a personal touch to that. People who speak the same (natural) language still speak differently to some extent, and programming is kind of the same. Each programmer would have their way of solving the same problem even within the constraints of a single language or framework.

## Technology Choices vs Business Problem-Solving

The internet has its fair share of people who believe their favorite technology is *The Way*, and every other technology is absolute trash. What they fail to realize is that they obsess over things that usually have little practical impact. Users/clients/non-tech managers won't care about bundle sizes, much less developer experience or code elegance. I know it's a bit of a generalization, but I don't think it's an unrealistic one.

I once worked on a project where we shipped a monthly report as a static site. The tool I worked with produced a self-contained HTML file, meaning that all the markup, CSS, and JS required to render the report was embedded in the HTML file. It didn't have tree-shaking or anything like that, so it embedded *whole JS libraries* in the HTML! The file size was 10-12 MBs... a static site! Atrocious by today's standards, but that's what I had at the time and didn't know better. Anyway, not only did our clients not care about the slowness of the site, their minds were blown because we solved a business problem they couldn't imagine. It was a huge win for me at the company.

*P.S. I did rewrite that project with a modern JS framework, and I wish the web and its community would accept my apologies.*

## Shiny Object Syndrome

A large percentage of us are strongly attracted to technologies that are new in general or new to us, and we keep playing with them until the honeymoon period passes and another shiny technology appears. Then, the cycle repeats again and again. That's SOS in a nutshell, and it blinds us greatly. You could start and maintain a project for a long time in a certain framework just because you were fascinated by it a the time you started the project.

Actually, I would give some considerable credit to SOS for helping me discover new things and expand my knowledge greatly. I wouldn't be the developer that I am today if I wasn't curious about languages, frameworks, and programming in general. So, SOS can be very rewarding if you're careful with it.

The bad side of it, though, is the constant distraction if you give it too much power. If you don't have at least one tool that you're constantly getting better at, then you are only learning the basics of a lot of tools – a "jack of all trades, master of none." Sometimes, I think that I fall into this category. I may have been a pro in one tool if I focused on it all those years. Instead, if I'll build a Dunning-Kruger curve for each tool I know, I am always nowhere near the last part in any of those curves.

![dunnnig-kruger curve](https://imgur.com/c4SkZ09.jpg)

The Dunning-Kruger effect is actually a perfect segue for talking about...

## Ego

Programming may or may not be hard - I won't argue that - but in either case, non-programmers think that what we do is hard... that we are geniuses to be able to write code like this. I guess that might feed the ego of some developers by making them feel superior because they know things you don't know, even if you're a developer like them.

I guess that might generalize to anyone in engineering, not just software. Some think that they are so smart because they throw equations or logical arguments at things as if they deal in absolute truths. Even worse are those who do any sort of teaching and talk about fundamentals as if they're so obvious and treat students like "How can you not get that?" I've seen a fair share of them, and they are always infuriating to me. Looking at the Dunning-Kruger curve above, I can't help but place them at the peak of Mt. Stupid! I strongly believe you can't talk like a know-it-all without being clueless about what you don't know yet.

## What to Do About It

I presented my case on why programmers are not as rational as they think. Next, I'll address each point, starting from the last:

1. **Stay humble**: your ego will always be a source of problems for you, and it will hinder your learning and improvement. Remember that no matter how much you rationalize, there's always a margin of error. (Maybe learn some statistics, where margins of error are literally in the equations. :D)
    
2. **Stay focused**: focus on the tool you want to learn and on the software you want to build or the problem you want to solve. You can try and compare languages, of course (I do that myself and hopefully always will), but always remember where your "center" is and don't stray too far.
    
3. **Embrace subjectivity**: I started to believe in recent years that we really shouldn't obsess over rationalizations and any forms of truth-seeking. They are not inherently bad at all, but you need to acknowledge that a large part of coding depends on you and your taste, not on what's right. It's totally fine.
    

## Conclusion

That was my perspective on our objectivity as software developers. Let me know what you think, and thanks for reading!

* * *

Cover image generated with [Leonardo AI](https://leonardo.ai/)

This only contains one file, Driver.java. It runs in the terminal with just native Java stuff. 

The Legendre symbol is a simple notation for describing whether a number is a quadratic residue in the integers mod some prime. It is a specific case of the Jacobi symbol.

This showcases some of my favorite elementary number theory: it takes advantage of the Law of Quadratic Reciprocity, Gauss's Lemma, the fact that the Legendre symbol is completely multiplicative, and the fact that Legendre(A/B) = Legendre((A mod B)/B).

~ ~ ~ ~ ~ 

This program is currently very inefficient and I plan on reworking it in the future as an exercise. Using the Law of Quadratic Reciprocity is unnecessary and introduces a special case requiring Gauss's Lemma. This program can be written using only basic properties of the Legendre symbol, and does not require the use of these theorems. The demonstration of the math is cool, but not useful here. 

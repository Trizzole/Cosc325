#lang racket

(define (sayHello name) (printf "hello ~a" name))

;(sayHello "tom")

;(define (max lis)
 ; (if (empty? lis) 0 (car (sort lis >))))

(define (max2 lis)
  (if (empty? lis) 0 (if (> (car lis) (max (cdr lis))) (car lis) (max (cdr lis)))))

;(max2 '( 0 2 3 4 5 7))

;(max '(0 2 1 4 6))

(define (deepmax2 lis)
  (cond ((empty? lis) 0)
        ((= 1 (length lis)) (if (list? (car lis)) (deepmax2 (car lis)) (car lis)))
        (else (if (list? (car lis))
                  (if (> (deepmax2 (car lis)) (deepmax2 (cdr lis))) (deepmax2 (car lis)) (deepmax2 (cdr lis)))
                  (if (> (car lis) (deepmax2 (cdr lis))) (car lis) (deepmax2 (cdr lis)))))))
     
(deepmax2 '(6 (7 (4))))

;(let [(newLessThan) (< (length a) (length b))])
;(define (lessthan lisa lisb) (< (length lisa) (length lisb)))

; part 4


(define (lensort a b)
  (< (length a) (length b)))

(sort '((1 2 3 4 5 6 )() (1 2) (3 4 5) (6 7 8 9)) lensort)

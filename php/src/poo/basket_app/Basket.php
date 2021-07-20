<?php
declare(strict_types = 1);

namespace abcd2105\basket_app;

use abcd2105\basket_app\Fruit;

class Basket
{
    private int $ref;
    private Fruit $fruits;


    public function __construct(int $ref, Fruit $fruit)
    {
        // ...
    }

    public function getTotalPrice(): float
    {
        // ...
    }
}
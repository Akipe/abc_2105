<?php
declare(strict_types = 1);

namespace abc2105\basket_app;

use abc2105\basket_app\Fruit;

class Basket
{
    private int $ref;
    private array $fruits;


    public function __construct(int $ref, Fruit $fruit)
    {
        // ...
    }

    public function getTotalPrice(): float
    {
        // ...
    }
}
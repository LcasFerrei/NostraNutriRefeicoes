const cards = document.querySelectorAll('.expanding-card');

cards.forEach((card) => {
    card.addEventListener('click', () => {
        cards.forEach((c) => c.classList.remove('active')); // Remove classe ativa de outros cards
        card.classList.add('active'); // Adiciona ao card clicado
    });
});


let scrollAmount = 0;

function scrollLeft() {
    const container = document.querySelector('.expanding-cards');
    const cardWidth = container.querySelector('.expanding-card').offsetWidth + 10; // Inclui o gap entre cards
    scrollAmount -= cardWidth;
    container.style.transform = `translateX(${scrollAmount}px)`;
}

function scrollRight() {
    const container = document.querySelector('.expanding-cards');
    const cardWidth = container.querySelector('.expanding-card').offsetWidth + 10; // Inclui o gap entre cards
    scrollAmount += cardWidth;
    container.style.transform = `translateX(${scrollAmount}px)`;
}


// Detecta quando o elemento entra na tela
document.addEventListener("scroll", function () {
    var elements = document.querySelectorAll('.scroll-animation');
    elements.forEach(function (element) {
        var position = element.getBoundingClientRect().top;
        var windowHeight = window.innerHeight;

        if (position < windowHeight - 50) {
            element.classList.add('visible');
        }
    });
});

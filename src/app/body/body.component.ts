import {Component, AfterViewInit, ViewChild, ElementRef, Renderer2, ContentChildren, QueryList} from '@angular/core';

@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css']
})
export class BodyComponent implements AfterViewInit {
  @ViewChild('counter1', { read: ElementRef }) counter1!: ElementRef;
  @ViewChild('counter2', { read: ElementRef }) counter2!: ElementRef;
  @ViewChild('counter3', { read: ElementRef }) counter3!: ElementRef;
  @ViewChild('counter4', { read: ElementRef }) counter4!: ElementRef;

  constructor(private renderer: Renderer2) {}

  animateNumbers() {
    this.animateCounter(this.counter1);
    this.animateCounter(this.counter2);
    this.animateCounter(this.counter3);
    this.animateCounter(this.counter4);
  }
  animateCounter(counter: ElementRef) {
    const element = counter.nativeElement;
    const countTo = element.textContent;
    let countNum = parseFloat(countTo.replace(/[^\d.]/g, ''));

    const animate = () => {
      if (countNum <= parseFloat(countTo.replace(/[^\d.]/g, ''))) {
        this.renderer.setProperty(element, 'textContent', (countNum++).toLocaleString() + countTo.match(/[^\d]+/));
        setTimeout(animate, 1000);
      } else {
        this.renderer.setProperty(element, 'textContent', countTo);
      }
    };
    animate();
  }

  ngAfterViewInit() {
    this.animateNumbers();
  }
}

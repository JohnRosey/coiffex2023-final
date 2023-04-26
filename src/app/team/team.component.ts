import { Component, OnInit, AfterViewInit } from '@angular/core';
import * as $ from 'jquery';
import { TweenLite } from 'gsap';

@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit, AfterViewInit {
  private moveCircle: any;
  private overlayMousemove: any;
  private overlayMouseout: any;

  constructor() { }

  ngOnInit(): void {
  }

  ngAfterViewInit(): void {
    this.initializeCursor();
  }

  private initializeCursor(): void {
    const $cursor = $(".cursor");
    const $overlay = $(".project-overlay");

    function moveCircle(e: any): void {
      TweenLite.to($cursor, 0.5, {
        css: {
          left: e.pageX,
          top: e.pageY
        },
        delay: 0.03
      });
    }

    $(".p-1").hover(function() {
      $cursor.css({ "background-image": "url(https://images.unsplash.com/photo-1477704080907-b04e4e2d3282?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1950&q=80)" });
    });

    $(".p-2").hover(function() {
      $cursor.css({ "background-image": "url(https://images.unsplash.com/photo-1553979199-b0b04376d319?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=934&q=80)" });
    });

    $(".p-3").hover(function() {
      $cursor.css({ "background-image": "url(https://images.unsplash.com/photo-1557263432-f37dd16f6d08?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=934&q=80)" });
    });

    $(".p-4").hover(function() {
      $cursor.css({ "background-image": "url(https://images.unsplash.com/photo-1512830414785-9928e23475dc?ixlib=rb-1.2.1&auto=format&fit=crop&w=1950&q=80)" });
    });

    let flag = false;
    $overlay.mousemove(function() {
      flag = true;
      TweenLite.to($cursor, 0.3, { scale: 1, autoAlpha: 1 });
      $overlay.on("mousemove", moveCircle);
    });
    $overlay.mouseout(function() {
      flag = false;
      TweenLite.to($cursor, 0.3, { scale: 0.1, autoAlpha: 0 });
    });
  }
}

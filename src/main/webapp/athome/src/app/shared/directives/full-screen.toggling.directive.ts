import {AfterViewInit, Directive, ElementRef, HostListener, Inject, Renderer2} from '@angular/core';
import {DOCUMENT} from "@angular/common";

@Directive({
  selector: '[fsToggler]'
})
export class FullScreenTogglingDirective implements AfterViewInit {
  documentEl: any;

  constructor(@Inject(DOCUMENT) private doc: any, private elementRef: ElementRef, private renderer: Renderer2) {
    this.documentEl = doc.documentElement;
  }


  ngAfterViewInit(): void {
    this.exitFullScreen();
  }

  @HostListener('click', ['$event'])
  onDoubleClick(event: MouseEvent) {
    let isFS = this.isFullScreen();
    if (isFS) {
      this.exitFullScreen();
    } else {
      this.enterFullScreen();
    }
  }


  isFullScreen(): boolean {
    return (this.doc.fullscreenElement && this.doc.fullscreenElement !== null)
      || this.doc.webkitIsFullScreen;
  }

  enterFullScreen() {
    this.documentEl.requestFullscreen();
    this.elementRef.nativeElement.innerHTML = 'fullscreen_exit';
    this.renderer.setProperty(this.elementRef.nativeElement, 'title', 'Dbl click to exit Full Screen');
  }

  exitFullScreen() {
    if (this.isFullScreen()) {
      this.doc.exitFullscreen();
    }
    this.elementRef.nativeElement.innerHTML ='fullscreen';
    this.renderer.setProperty(this.elementRef.nativeElement, 'title', 'Dbl click to set Full Screen');
  }
}

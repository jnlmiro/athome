import {
  Component,
  ElementRef, EventEmitter,
  forwardRef,
  HostListener,
  Input,
  OnChanges,
  OnInit, Output,
  Renderer2,
  SimpleChanges,
  TemplateRef,
  ViewChild,
  ViewContainerRef
} from '@angular/core';
import {ControlValueAccessor, NG_VALUE_ACCESSOR} from "@angular/forms";


enum Key {
  Backspace = 8,
  Tab = 9,
  Enter = 13,
  Shift = 16,
  Escape = 27,
  ArrowLeft = 37,
  ArrowRight = 39,
  ArrowUp = 38,
  ArrowDown = 40
}

@Component({
  selector: 'input[typeahead]',
  templateUrl: 'typeahead.component.html',
  styleUrls: ['typeahead.component.scss'],
  host: {
    'autocomplete': 'off',
    'autocapitalize': 'off',
    'autocorrect': 'off',
  },
  providers: [{
    provide: NG_VALUE_ACCESSOR,
    useExisting: forwardRef(() => TypeaheadComponent),
    multi: true
  }],
})

export class TypeaheadComponent implements OnInit, OnChanges, ControlValueAccessor {

  @Input() searchResults: [any];
  @Input() itemTplRef: TemplateRef<any>;
  @Input('inputFormatter') inputFormatter: (value: any) => string;
  @Output() onSelect:EventEmitter<any> = new EventEmitter<any>();

  @ViewChild('suggestionsTplRef') suggestionsTplRef;

  private activeItemIdx: number = 0;
  private resultsVisible: boolean = true;

  constructor(private viewContainer: ViewContainerRef,
              private elementRef: ElementRef,
              private renderer: Renderer2) {
  }

  ngOnInit(): void {
    this.renderContents();
  }


  ngOnChanges(changes: SimpleChanges): void {
    this._handleResultChanges(changes);
  }


  _handleResultChanges(changes: SimpleChanges) {
    let currentValue = changes.searchResults.currentValue;
    let oldValue = changes.searchResults.previousValue;

    if (currentValue.length === 0) {
      this._resetActiveItem();
    } else if (oldValue && currentValue.length < oldValue.length) {
        this._resetActiveItem();
    }

    this._enableSuggestions();
  }


  writeValue(obj: any): void {
    this._writeValue(this.inputFormatter(obj));
    this.onSelect.emit(obj);
  }


  _writeValue(value: string) {
    this.renderer.setProperty(this.elementRef.nativeElement, 'value', value);

  }

  registerOnChange(fn: any): void {
  }

  registerOnTouched(fn: any): void {
  }

  setDisabledState(isDisabled: boolean): void {
  }

  /*
  * Keys and mouse navigation
  * */
  @HostListener('keydown', ['$event'])
  onKeyDown(event: KeyboardEvent) {
    if (event.keyCode === Key.ArrowDown) {
      this._setActiveItem(1);
    }

    if (event.keyCode === Key.ArrowUp) {
      this._setActiveItem(-1);
    }

    if (event.keyCode === Key.Enter) {
      this.selectItem();
    }
  }


  onMouseEnter(event: MouseEvent, idx) {
    this.activeItemIdx = idx;
  }


  @HostListener('document:click', ['$event'])
  onClickOutSide(event) {
    let thisEl = this.elementRef.nativeElement;

    if (!thisEl.contains(event.target)) {
      this._disableSuggestions();
    } else if (event.target === thisEl) {
      if (this.resultsVisible === false) {
        this._enableSuggestions();
      }
    }
  }


  _disableSuggestions() {
    this.resultsVisible = false;
  }

  _enableSuggestions() {
    this.resultsVisible = true;
  }

  _setActiveItem(iCursor) {
    if (this.activeItemIdx === 0 && iCursor === -1) {
      this.activeItemIdx = this.searchResults.length - 1;
    } else if (this.activeItemIdx === this.searchResults.length - 1 && iCursor === 1) {
      this.activeItemIdx = 0;
    } else {
      this.activeItemIdx += iCursor
    }
  }

  _resetActiveItem() {
    this.activeItemIdx = 0;
  }


  selectItem() {
    let selectedItem = this.searchResults[this.activeItemIdx];
    this.writeValue(selectedItem);
    this._disableSuggestions();
  }


  renderContents() {
    this.viewContainer.createEmbeddedView(this.suggestionsTplRef);
  }
}

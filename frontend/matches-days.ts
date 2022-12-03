import { LitElement, html, css, customElement } from 'lit-element';

@customElement('matches-days')
export class MatchesDays extends LitElement {
  static get styles() {
    return css`
      :host {
          display: block;
          height: 100%;
      }
      `;
  }

  render() {
    return html`
<vaadin-button theme="icon" aria-label="Add new" id="vaadinButton" tabindex="0"></vaadin-button>
<vaadin-button theme="icon" aria-label="Add new" id="vaadinButton1" tabindex="0"></vaadin-button>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}

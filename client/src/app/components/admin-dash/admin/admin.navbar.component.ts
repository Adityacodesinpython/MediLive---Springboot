
import { Component } from '@angular/core';
import { HlmButtonDirective } from '@spartan-ng/ui-button-helm';
import { BrnMenuTriggerDirective } from '@spartan-ng/ui-menu-brain';
import {
  HlmMenuBarComponent,
  HlmMenuBarItemDirective,
  HlmMenuComponent,
  HlmMenuGroupComponent,
  HlmMenuItemCheckboxDirective,
  HlmMenuItemCheckComponent,
  HlmMenuItemDirective,
  HlmMenuItemIconDirective,
  HlmMenuItemRadioComponent,
  HlmMenuItemRadioDirective,
  HlmMenuItemSubIndicatorComponent,
  HlmMenuLabelComponent,
  HlmMenuSeparatorComponent,
  HlmMenuShortcutComponent,
  HlmSubMenuComponent,
} from '@spartan-ng/ui-menu-helm';

@Component({
  selector: 'admin-navbar',
  standalone: true,
  imports: [
    BrnMenuTriggerDirective,

    HlmMenuComponent,
    HlmMenuBarComponent,
    HlmSubMenuComponent,
    HlmMenuItemDirective,
    HlmMenuItemSubIndicatorComponent,
    HlmMenuLabelComponent,
    HlmMenuShortcutComponent,
    HlmMenuSeparatorComponent,
    HlmMenuItemIconDirective,
    HlmMenuBarItemDirective,
    HlmMenuItemCheckComponent,
    HlmMenuItemRadioComponent,
    HlmMenuGroupComponent,

    HlmButtonDirective,
    HlmMenuItemCheckboxDirective,
    HlmMenuItemRadioDirective,
  ],
  template: `
    <hlm-menu-bar class="min-w-96 px-3 min-h-16 flex-row justify-between">
      <button hlmMenuBarItem class="min-w-20 flex text-md justify-center h-12" [brnMenuTriggerFor]="file">Home</button>
      <button hlmMenuBarItem class="min-w-20 flex text-md justify-center h-12" [brnMenuTriggerFor]="edit">About</button>
      <button hlmMenuBarItem class="min-w-20 flex text-md justify-center h-12" [brnMenuTriggerFor]="view">Profile</button>
      <button hlmBtn hlmMenuBarItem class="min-w-20 flex text-md justify-center h-12" [brnMenuTriggerFor]="profiles">Create New</button>
    </hlm-menu-bar>

    <ng-template #file>
      <hlm-menu variant="menubar" class="w-48">
        <hlm-menu-group>
          <button hlmMenuItem>
            New Tab
            <hlm-menu-shortcut>⌘T</hlm-menu-shortcut>
          </button>
          <button hlmMenuItem>
            New Window
            <hlm-menu-shortcut>⌘N</hlm-menu-shortcut>
          </button>
          <button hlmMenuItem disabled>New Incognito Window</button>
        </hlm-menu-group>

        <hlm-menu-separator />

        <button hlmMenuItem [brnMenuTriggerFor]="share">
          Share
          <hlm-menu-item-sub-indicator />
        </button>

        <hlm-menu-separator />
      </hlm-menu>
    </ng-template>

    <ng-template #share>
      <hlm-sub-menu>
        <button hlmMenuItem>Email link</button>
        <button hlmMenuItem>Messages</button>
        <button hlmMenuItem>Notes</button>
      </hlm-sub-menu>
    </ng-template>

    <ng-template #edit>
      <hlm-menu variant="menubar" class="w-48">
        <hlm-menu-group>
          <button hlmMenuItem>
            Undo
            <hlm-menu-shortcut>⌘Z</hlm-menu-shortcut>
          </button>
          <button hlmMenuItem>
            Redo
            <hlm-menu-shortcut>⇧⌘Z</hlm-menu-shortcut>
          </button>
        </hlm-menu-group>

        <hlm-menu-separator />

        <button hlmMenuItem [brnMenuTriggerFor]="find">
          Share
          <hlm-menu-item-sub-indicator />
        </button>

        <hlm-menu-separator />

        <button hlmMenuItem>Cut</button>
        <button hlmMenuItem>Copy</button>
        <button hlmMenuItem>Paste</button>
      </hlm-menu>
    </ng-template>
    <ng-template #find>
      <hlm-sub-menu>
        <button hlmMenuItem>Search the web</button>
        <hlm-menu-separator />
        <button hlmMenuItem>Find...</button>
        <button hlmMenuItem>Find Next</button>
        <button hlmMenuItem>Find Previous</button>
      </hlm-sub-menu>
    </ng-template>

    <ng-template #view>
      <hlm-menu variant="menubar">
        <button hlmMenuItemCheckbox>
          <hlm-menu-item-check />
          Always Show Bookmarks Bar
        </button>
        <button hlmMenuItemCheckbox checked>
          <hlm-menu-item-check />
          Always Show Full URLs
        </button>
        <hlm-menu-separator />
        <button inset hlmMenuItem>
          Reload
          <hlm-menu-shortcut>⌘R</hlm-menu-shortcut>
        </button>
        <button inset disabled hlmMenuItem>
          Force Reload
          <hlm-menu-shortcut>⇧⌘R</hlm-menu-shortcut>
        </button>
        <hlm-menu-separator />
        <button inset hlmMenuItem>Toggle Fullscreen</button>
        <hlm-menu-separator />
        <button inset hlmMenuItem>Hide Sidebar</button>
      </hlm-menu>
    </ng-template>

    <ng-template #profiles>
      <hlm-menu variant="menubar" class="w-48">
        <button hlmMenuItemRadio>
          <hlm-menu-item-radio />
          Andy
        </button>
        <button hlmMenuItemRadio checked>
          <hlm-menu-item-radio />
          Benoit
        </button>
        <button hlmMenuItemRadio>
          <hlm-menu-item-radio />
          Lewis
        </button>
        <hlm-menu-separator />
        <button inset hlmMenuItem>Edit...</button>
        <hlm-menu-separator />
        <button inset hlmMenuItem>Add Profile...</button>
      </hlm-menu>
    </ng-template>
  `,
})
export class AdminNavbarComponent {}

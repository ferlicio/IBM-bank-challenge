import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaterialModule } from 'src/app/material/material.module';
import { ReactiveFormsModule } from '@angular/forms';
import { FormDialogComponent } from './form-dialog.component';



@NgModule({
  declarations: [FormDialogComponent],
  imports: [
    MaterialModule,
    CommonModule,
    ReactiveFormsModule,
  ],
  exports:[FormDialogComponent]
})
export class FormDialogModule { }
